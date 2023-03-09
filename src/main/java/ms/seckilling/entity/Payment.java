package ms.seckilling.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ToString
@TableName("payment")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pay_id", type = IdType.AUTO)
    private Integer payId;

    private Long secKillId;

    private Long userId;

    private Short state;

    private BigDecimal money;

    private LocalDateTime createTime;
}
