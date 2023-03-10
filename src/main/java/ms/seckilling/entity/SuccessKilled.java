package ms.seckilling.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ToString
@TableName("success_killed")
public class SuccessKilled implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "suc_id", type = IdType.AUTO)
    private Integer sucId;

    private Long secKillId;

    private Long userId;

    private Short state;

    private LocalDateTime createTime;
}
