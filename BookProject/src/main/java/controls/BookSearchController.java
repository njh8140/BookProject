package controls;

import java.util.Map;

import DAO.BookDao;
import bind.DataBinding;

public class BookSearchController implements Controller, DataBinding {
	BookDao bookDao;

	@Override
	public Object[] getDataBinders() {
		return new Object[] {"keyword", String.class};
	}
	
	public BookSearchController setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String keyword = (String)model.get("keyword");
		model.put("books", bookDao.searchTitle(keyword));
		
		return "/book/BookList.jsp";
		}
	}