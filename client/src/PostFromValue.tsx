import React, { useState } from "react";



function PostFromValues(props) {

    const [formValue, setFormValue] = useState({ englishWord: '', translatedWeord: '' });
    const handleInput = (e) => {
        const { englishWord, value } = e.target;
        setFormValue({ ...formValue, [englishWord]: value });
        console.log(formValue);
    }

    const handleFormsubmit = async (e) => {
        e.preventDefault();

        await fetch('http://localhost:8080/all-word/add', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                englishWord: formValue.englishWord,
                translatedWord: formValue.translatedWeord

            })
        });
        console.log("success");

    }

    return (
        <React.Fragment>

            <div className="row">
                <div className="col-sm-8 text-success">
                    <h5 className="mt-3 mb-3  text-white">
                        Post Form Data to Fetch API with React JS

                    </h5>

                    <form className='row' onSubmit={handleFormsubmit}>
                        <div className="col-md-3">
                            <label className="form-label text-white">English</label>
                            <input type="text" name='englishWord' value={formValue.englishWord} onChange={handleInput} className='form-control' placeholder='English...' />
                        </div>

                        <div className="col-md-3">
                            <label className="form-label text-white">Translate</label>
                            <input type="text" name='translated' value={formValue.translatedWeord} onChange={handleInput} className='form-control' placeholder='Email...' />
                        </div>

                        <div className="col-md-2">
                            <label className="form-label text-white">Action</label>
                            <button className='form-control btn btn-success '>Submit</button>
                        </div>


                    </form>

                </div>
            </div>

        </React.Fragment>
    );

}

export default PostFromValues;
