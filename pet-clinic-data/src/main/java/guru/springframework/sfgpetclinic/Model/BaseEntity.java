package guru.springframework.sfgpetclinic.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
/////// برای کلاس پدر هیچ جدولی ساخته نخواهد شد ولی فیلدهای آن به ساب کلاس ها منتقل خواهد شد و در جدول ساب کلاس ها خواهد بود
//@MappedSuperclass means this supper class will not have any table in DB but its children will have its properties
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isNew () {
        return this.id == null;
    }
}
