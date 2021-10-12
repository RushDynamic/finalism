import React from 'react';

function ErrorContent(errorMsg) {
    return (
        <>
            <h1>{errorMsg}</h1>
        </>
    )
}

function SuccessContent(shortUrl) {
    return (
        <>
            <h4>Here's your shortened URL:</h4>
            <h2 style={{ marginTop: '0vh' }}>{shortUrl}</h2>
            <button className="result-copy-btn" type="button" onClick={() => navigator.clipboard.writeText(shortUrl)}>COPY</button>
        </>
    )
}

function ResultContent(props) {
    return (
        <div>
            {
                (
                    props.error.isError ? ErrorContent(props.error.message) : SuccessContent(props.shortUrl)
                )
            }
        </div>
    );
}

export default ResultContent;