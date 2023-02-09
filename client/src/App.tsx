// import React from 'react';
// import './App.css';
// import logo from './logo.svg';
// import WordList from './WordList';
// import AddWord from './AddWord';



// class App extends React.Component<{}, any> {
//   constructor(props: any) {
//     super(props);

//     this.state = {
//       words: [],
//       isLoading: false
//     };
//   }


//   componentDidMount() {
//     this.setState({ isLoading: true });

//     fetch('http://localhost:8080/all-word')
//       .then(response => response.json())
//       .then(data => this.setState({ words: data, isLoading: false }));
//   }



//   render() {
//     const { words, isLoading } = this.state;

//     if (isLoading) {
//       return <p>Loading...</p>;
//     }

//     return (
//       <>
//         <div className="App">

//           <WordList />
//           <AddWord />

//         </div>

//       </>
//     );
//   }




// }


// export default App;


import React from 'react';
import './App.css';
import logo from './logo.svg';
import WordList from './WordList';
import AddWord from './AddWord';



class App extends React.Component<{}, any> {
  constructor(props: any) {
    super(props);

    this.state = {
      words: [],
      isLoading: false,
      showAddWord: false,
    };
  }


  componentDidMount() {
    this.setState({ isLoading: true });

    fetch('http://localhost:8080/all-word')
      .then(response => response.json())
      .then(data => this.setState({ words: data, isLoading: false }));
  }

  handleAddWord = () => {
    this.setState({ showAddWord: true });
  };



  render() {
    const { words, isLoading, showAddWord } = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <>
        <div className="App">

          <WordList />
          <button onClick={this.handleAddWord}>Add word</button>
          {showAddWord && <AddWord/>}
        </div>

      </>
    );
  }




}


export default App;

