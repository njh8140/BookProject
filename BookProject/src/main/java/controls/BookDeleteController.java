package controls;

import java.util.Map;

import DAO.BookDao;
import bind.DataBinding;

public class BookDeleteController implements Controller, DataBinding {
	BookDao bookDao;

	@Override
	public Object[] getDataBinders() {
		return new Object[] {"id", Integer.class};
	}
	public BookDeleteController setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		bookDao.delete((Integer)model.get("id"));
		
		return "redirect:list.do";
	}
}