package snowcastervz.patterns.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import snowcastervz.patterns.model.Info;

public interface InfoRepository extends  JpaRepository<Info,Integer>{

}
