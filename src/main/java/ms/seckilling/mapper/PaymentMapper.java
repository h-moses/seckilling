package ms.seckilling.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ms.seckilling.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
}
