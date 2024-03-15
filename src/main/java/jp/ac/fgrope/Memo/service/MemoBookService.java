package jp.ac.fgrope.Memo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.fgrope.Memo.model.MemoBook;
import jp.ac.fgrope.Memo.repository.MemoBookRepository;

@Service
@Transactional
public class MemoBookService {

	@Autowired
	private MemoBookRepository repository;

	/**
	 * アドレス帳一覧の取得
	 * @return List<MemoBook>
	 */
	public List<MemoBook> getMemoList() {
	    List<MemoBook> entityList = this.repository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  MemoBook
	 */
	public MemoBook get(@NonNull Long index) {
		MemoBook MemoBook = this.repository.findById(index).orElse(new MemoBook());
		return MemoBook;
	}

	/**
	 * アドレス帳データの保存
	 * @param MoneyBook MemoBook
	 */
	public void save(@NonNull MemoBook MemoBook) {
		this.repository.save(MemoBook);
	}

	/**
	 * アドレス帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}
}
