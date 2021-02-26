import React from "react";
import { useParams } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import "./style/CombineStyles.css";

function check(array, attr, value) {
  for(var i = 0; i < array.length; i += 1) {
      if(array[i][attr] == value) {
          return array[i];
      }
  }
  return -1;
}
export const BookDetails = () => {

  let { id } = useParams();
  const books = useSelector((state) => state.bookStorage) || [];
  let selectedBook = check(books, "bookId", id);

  return (
    <div >
      <div class="cardview1">
        <div class="heading">
          <h1 class="text-black"> {selectedBook.bookName}</h1>
        </div>

        <div class="text-box">
          <p>
            The Book Id : {selectedBook.bookId} 
          </p>
          <p>
            The Author of the book : {selectedBook.bookAuthor}
          </p>
          <p>
            Book ISBN Number : {selectedBook.bookIsbn}
          </p>
          <p>
            Price of the book: Rs. {selectedBook.bookPrice}
          </p>
          
        </div>
      </div>
    </div>
  );
};
