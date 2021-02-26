const createBook = (bookId, bookName, bookAuthor,bookIsbn,bookPrice) => ({
  bookId, 
  bookName, 
  bookAuthor,
  bookIsbn,
  bookPrice,
  
  })

const bookStorage = (books = [], action) => {
    switch (action.type) {
      case 'INSERT_BOOK':
        return [...books, createBook(action.bookId, action.bookName, action.bookAuthor,
          action.bookIsbn, action.bookPrice)]
      default:
        return books
    }
  }
  
export default bookStorage