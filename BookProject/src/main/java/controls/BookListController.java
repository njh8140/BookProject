package controls;

import java.util.Map;

import DAO.BookDao;

public class BookListController implements Controller {
	BookDao bookDao;
	
	public BookListController setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
		return this;	
		}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("books", bookDao.selectAll());
		return "/book/BookList.jsp";
	}
}