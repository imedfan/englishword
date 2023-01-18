import * as React from 'react';

class WordList extends React.Component<{}, any>{
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
            <div>
                <h2>Word List</h2>
                {words.map((word: any) =>
                    <div key={word.id}>
                        {word.englishWord}
                        &nbsp; : &nbsp;
                        {word.translatedWord}
                    </div>
                )}
            

            </div>
        );
    }
}

export default WordList;