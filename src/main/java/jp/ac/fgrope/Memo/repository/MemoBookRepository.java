package jp.ac.fgrope.Memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.fgrope.Memo.model.MemoBook;


@Repository
public interface MemoBookRepository extends JpaRepository<MemoBook, Long> {
	
}
