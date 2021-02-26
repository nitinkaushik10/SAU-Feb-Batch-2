let bookId = 1;

export const insertBook = (bookName,bookAuthor,bookIsbn,bookPrice) => {
    return { 
        type: 'INSERT_BOOK', bookId:bookId++, bookName, bookAuthor, bookIsbn,bookPrice
     }
}