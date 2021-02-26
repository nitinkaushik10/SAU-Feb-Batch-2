import React, { useState } from "react";
import "./style/CombineStyles.css";
import { useSelector } from "react-redux";
import { Link } from "react-router-dom";
import { Form } from "react-bootstrap";

export function checks(array, attr, value) {
  let arr = [];
  if(value == ""){
      return array;
  }
  for(var i = 0; i < array.length; i += 1) {
      if(array[i][attr] == value) {
          arr.push(array[i]);
      }
  }
  return arr;
}
export const SearchBook = () => {
  const [input, setInput] = useState("");
  const completeRecords = useSelector((state) => state.bookStorage) || [];

  let bookRecord = checks(completeRecords, "bookName", input).map((book, i) => (

    <tr key={i}>
      <td>{i+1}</td>
      <td>
        <Link to={"/detail/" + book.bookId}>{book.bookName}</Link>
      </td>
      <td>{book.bookAuthor}</td>
      <td>{book.bookIsbn}</td>
    </tr>
  ));
  console.log(completeRecords);
  return (
    
    <div style={{ 
      
      backgroundRepeat: 'no-repeat',
      height:"700px"
    }}>
      <Form.Group>
      <center>
        <h1></h1>
       
          <h1 class="text-success">Search Book</h1>
        
      </center>
        <Form.Control onInput={(e) => setInput(e.target.value)}  className="trans" size="lg" type="text" placeholder="Search for books" />
      </Form.Group>
      <center>
      <table class="tableview">
        <thead >
          <tr>
            <th>Book Id</th>
            <th>Book Name</th>
           <th>Book Author</th> 
           <th>Book ISBN</th> 
          </tr>
        </thead>
        <tbody>{bookRecord}</tbody>
      </table>
      </center>
    </div>
  );
};
