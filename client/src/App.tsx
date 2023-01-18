import React from 'react';
import './App.css';
import logo from './logo.svg';
import WordList from './WordList';


class App extends React.Component<{}, any> {
  constructor(props: any) {
    super(props);

    this.state = {
      words: [],
      isLoading: false
    };
  }


  componentDidMount() {
    this.setState({ isLoading: true });

    fetch('http://localhost:8080/all-word')
      .then(response => response.json())
      .then(data => this.setState({ words: data, isLoading: false }));
  }


  render() {
    const { words, isLoading } = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div className="App">
        {/* <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Welcome to WordList</h2>
        </div> */}
        <WordList />
      </div>
    );
  }


}


export default App;
