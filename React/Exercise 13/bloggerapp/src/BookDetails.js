import React from "react";

function BookDetails() {

  const books = [
    {
      id: 1,
      name: "Master React",
      price: 670
    },
    {
      id: 2,
      name: "Deep Dive into Angular 11",
      price: 800
    },
    {
      id: 3,
      name: "Mongo Essentials",
      price: 450
    }
  ];

  return (
    <div>
      <h2>Book Details</h2>

      <table border="1" cellPadding="8">
        <thead>
          <tr>
            <th>ID</th>
            <th>Book Name</th>
            <th>Price</th>
          </tr>
        </thead>

        <tbody>
          {books.map((book) => (
            <tr key={book.id}>
              <td>{book.id}</td>
              <td>{book.name}</td>
              <td>{book.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default BookDetails;
