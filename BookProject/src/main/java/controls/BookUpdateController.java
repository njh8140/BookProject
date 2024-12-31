package controls;

import java.util.Map;

import DAO.BookDao;
import bind.DataBinding;
import vo.Book;

public class BookUpdateController implements Controller, DataBinding {
	BookDao bookDao;
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"id", Integer.class, "book", vo.Book.class};
	}
	
	public BookUpdateController setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Book book =(Book)model.get("book");
		
		if(book.getTitle() == null) {
			
			model.put("book", bookDao.selectOne((Integer)model.get("id")));
			
			return "/book/BookUpdate.jsp";
		} else {
			bookDao.update(book);
				
			return "redirect:list.do";
		}
	}
}