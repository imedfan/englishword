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

    handleDelete = async (id: number) => {
        try {
            const response = await fetch(`http://localhost:8080/all-word/delete/${id}`, {
                method: 'DELETE',
            });
    
            if (response.ok) {
                this.setState((prevState: { words: Array<any> }) => ({
                    words: prevState.words.filter((word: any) => word.id !== id),
                }));
            }
        } catch (error) {
            console.log(error);
        }
    };



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
                        &nbsp;  &nbsp;
                        <button onClick={() => this.handleDelete(word.id)}>Delete</button>
                    </div>
                )}
            

            </div>
        );
    }
}

export default WordList;