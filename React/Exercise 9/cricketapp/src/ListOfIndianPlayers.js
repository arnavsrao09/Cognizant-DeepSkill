import React from "react";

function ListOfIndianPlayers(props) {
  return (
    <div>
      <ul>
        {props.IndianPlayers.map((player, index) => (
          <li key={index}>Mr. {player}</li>
        ))}
      </ul>
    </div>
  );
}

export default ListOfIndianPlayers;