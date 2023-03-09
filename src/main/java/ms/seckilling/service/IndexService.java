package ms.seckilling.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ms.seckilling.api.Result;
import ms.seckilling.entity.SecKill;

public interface IndexService extends IService<SecKill> {

    Result startSecondKillByLock(long skgId, long userId);
}
