import * as React from 'react';

interface Props {

}

interface Word {
    englishWord: string;
    translatedWord: string;
}

interface State {
    word: Word;
}

class AddWord extends React.Component<Props, State> {

    constructor(props: Props) {
        super(props);
        this.state = {
            word: {
                englishWord: '',
                translatedWord: '',
            },
        };
    }


    handleEnglishWord = (event: React.ChangeEvent<HTMLInputElement>) => {
        this.setState({ word: { ...this.state.word, englishWord: event.target.value } });
    };

    handleTranslationWord = (event: React.ChangeEvent<HTMLInputElement>) => {
        this.setState({ word: { ...this.state.word, translatedWord: event.target.value } });
    };

    handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const { word } = this.state;

        console.log(word.translatedWord);

        try {
            const response = await fetch('http://localhost:8080/all-word/add', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(word),
            });

            if (!response.ok) {
                throw new Error(response.statusText);
            }
            console.log(JSON.stringify(word));
            const data = await response.json();
            console.log(data.translationWord);

            console.log(data);
        } catch (error) {
            console.log(error);
        }

    };

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <input
                    type="text"
                    value={this.state.word.englishWord}
                    onChange={this.handleEnglishWord}
                />
                <input
                    type="text"
                    value={this.state.word.translatedWord}
                    onChange={this.handleTranslationWord}
                />
                <button type='submit'>Save</button>
            </form>
        );
    }


}

export default AddWord;