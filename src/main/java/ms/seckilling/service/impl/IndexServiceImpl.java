package ms.seckilling.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ms.seckilling.api.Result;
import ms.seckilling.api.SecKillStateEnum;
import ms.seckilling.controller.IndexController;
import ms.seckilling.entity.Payment;
import ms.seckilling.entity.SecKill;
import ms.seckilling.entity.SuccessKilled;
import ms.seckilling.mapper.PaymentMapper;
import ms.seckilling.mapper.SecKillMapper;
import ms.seckilling.mapper.SuccessKilledMapper;
import ms.seckilling.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class IndexServiceImpl extends ServiceImpl<SecKillMapper, SecKill> implements IndexService {

    private static final Logger log = LoggerFactory.getLogger(IndexServiceImpl.class);

    @Resource
    private SuccessKilledMapper successKilledMapper;

    @Resource
    private PaymentMapper paymentMapper;

    private final ReentrantLock lock = new ReentrantLock(true);

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result startSecondKillByLock(long skgId, long userId) {
        lock.lock();
        try {
            log.info("用户:{} 开始秒杀 商品:{}", userId, skgId);
            //        校验库存
            SecKill secKill = getById(skgId);
            Integer number = secKill.getNumber();
            if (number > 0) {
//            扣库存
                secKill.setNumber(number - 1);
                updateById(secKill);

//            创建订单
                SuccessKilled successKilled = new SuccessKilled();
                successKilled.setSecKillId(skgId);
                successKilled.setUserId(userId);
                successKilled.setState((short) 0);
                successKilled.setCreateTime(LocalDateTime.now());
                successKilledMapper.insert(successKilled);

//            模拟支付
                Payment payment = new Payment();
                payment.setSecKillId(skgId);
                payment.setUserId(userId);
                payment.setMoney(BigDecimal.valueOf(40));
                payment.setState((short) 1);
                payment.setCreateTime(LocalDateTime.now());
                paymentMapper.insert(payment);
            } else {
                return Result.FAILURE(SecKillStateEnum.END);
            }
        } catch (Exception e) {
            return null;
        } finally {
            lock.unlock();
        }
        return Result.SUCCESS(SecKillStateEnum.SUCCESS);
    }
}
