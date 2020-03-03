package pri.xcz.hp.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pri.xcz.hp.application.model.BullPo;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BullDto {
    private Integer id;
    private String name;
    private Integer age;
    private Long createOn;
    private Long lastModifyOn;

    public BullDto(BullPo po) {
        this.id = po.getId();
        this.name = po.getName();
        this.age = po.getAge();
        this.createOn = po.getCreateOn();
        this.lastModifyOn = po.getLastModifyOn();
    }
}
