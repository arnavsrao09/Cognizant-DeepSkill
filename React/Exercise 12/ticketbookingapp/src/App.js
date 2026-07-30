import React, { Component } from "react";

// Login Button
function LoginButton(props) {
  return (
    <button onClick={props.onClick}>
      Login
    </button>
  );
}

// Logout Button
function LogoutButton(props) {
  return (
    <button onClick={props.onClick}>
      Logout
    </button>
  );
}

// Guest Page
function GuestGreeting() {
  return (
    <div>
      <h1>Please sign up.</h1>

      <h2>Available Flights</h2>

      <ul>
        <li>Bangalore → Delhi</li>
        <li>Chennai → Mumbai</li>
        <li>Hyderabad → Pune</li>
      </ul>
    </div>
  );
}

// User Page
function UserGreeting() {
  return (
    <div>
      <h1>Welcome back</h1>

      <h2>Book Your Tickets</h2>

      <table border="1" cellPadding="8">
        <thead>
          <tr>
            <th>Flight</th>
            <th>Status</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>Bangalore → Delhi</td>
            <td>Available</td>
          </tr>

          <tr>
            <td>Chennai → Mumbai</td>
            <td>Available</td>
          </tr>

          <tr>
            <td>Hyderabad → Pune</td>
            <td>Available</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

// Greeting Component
function Greeting(props) {
  if (props.isLoggedIn) {
    return <UserGreeting />;
  }

  return <GuestGreeting />;
}

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      isLoggedIn: false
    };
  }

  handleLoginClick = () => {
    this.setState({
      isLoggedIn: true
    });
  };

  handleLogoutClick = () => {
    this.setState({
      isLoggedIn: false
    });
  };

  render() {

    let button;

    if (this.state.isLoggedIn) {
      button = (
        <LogoutButton
          onClick={this.handleLogoutClick}
        />
      );
    } else {
      button = (
        <LoginButton
          onClick={this.handleLoginClick}
        />
      );
    }

    return (
      <div style={{ margin: "30px" }}>

        <Greeting
          isLoggedIn={this.state.isLoggedIn}
        />

        <br />

        {button}

      </div>
    );
  }
}

export default App;