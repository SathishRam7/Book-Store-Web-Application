package org.ram.repositary;
import org.ram.entity.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MyBookRepositary  extends JpaRepository<MyBookList,Integer>{

	
}

