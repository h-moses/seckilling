package ms.seckilling.controller;

import ms.seckilling.api.Result;
import ms.seckilling.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

@RestController
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Resource
    private IndexService indexService;

    @PostMapping("/seckilling")
    public Result startLock(@RequestParam("skgId") long skgId) {
        final long userId = (long) (new Random().nextDouble() * (99999 - 10000 + 1)) + 10000;
        Result result = indexService.startSecondKillByLock(skgId, userId);
        if (null != result) {
            log.info("用户:{}--{}", userId, result.getMessage());
        } else {
            log.info("用户:{}--{}", userId, "哎呦喂，人也太多了，请稍后！");
        }
        return result;
    }
}
