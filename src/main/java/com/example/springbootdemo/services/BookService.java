package com.example.springbootdemo.services;

import com.example.springbootdemo.dao.BookDAO;
import com.example.springbootdemo.model.Book;
import com.example.springbootdemo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;
    @Autowired
    CategoryService categoryService;
            public List<Book> list()
            {
                Sort sort=new Sort(Sort.Direction.DESC,"id");
                return bookDAO.findAll(sort);
            }

            public void addOrUpdate(Book book)
            {
                bookDAO.save(book);
            }

            public void deleteById(int id)
            {
                bookDAO.deleteById(id);
            }

            public List<Book> listByCategory(int cid)
            {
                Category category =categoryService.get(cid);
                Sort sort=new Sort(Sort.Direction.DESC,"id");
                return bookDAO.findAllByCategory(category);
            }

    public List<Book> Search(String keywords) {
        return bookDAO.findAllByTitleLikeOrAuthorLike('%' + keywords + '%', '%' + keywords + '%');
    }

}
