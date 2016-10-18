// IBookManager.aidl
package com.sample.aidl;

// Declare any non-default types here with import statements
import com.sample.aidl.Book;

interface IBookManager {
   void addBook(in Book book);
   List<Book> getList();
}
