package ms.seckilling.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ToString
@TableName("sec_kill")
public class SecKill implements Serializable {

    private static final Long serialVersionUID = 1L;

    @TableId(value = "sec_kill_id", type = IdType.AUTO)
    private Long secKillId;

    private String name;

    private Integer number;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDateTime createTime;

    @Version
    private Integer version;
}
