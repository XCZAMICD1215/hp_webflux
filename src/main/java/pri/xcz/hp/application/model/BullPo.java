package pri.xcz.hp.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;


@Table("bull")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BullPo implements Persistable {
    @Id
    private Integer id;
    private String name;
    private Integer age;
    @Column("create_on")
    private Long createOn;
    @Column("last_modify_on")
    private Long lastModifyOn;
    @Transient
    private Boolean na;

    @Override
    public boolean isNew() {
        return Objects.nonNull(na) && na;
    }
}
