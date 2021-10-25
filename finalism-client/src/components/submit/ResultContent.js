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
        <div style={{ display: 'flex', flexDirection: 'row', justifyContent: 'space-between', width: '100%' }}>
            <div>
                <h4 style={{ marginBottom: '0.5vh', color: '#454545' }}>Here's your shortened URL:</h4>
                <h2 style={{ marginTop: '0vh', color: 'black', textShadow: ' 1px 1px #ffffff' }}>{shortUrl}</h2>
            </div>
            <button style={{ marginLeft: '4vh' }} className="result-copy-btn" type="button" onClick={() => navigator.clipboard.writeText(shortUrl)}>COPY</button>
        </div>
    )
}

function ResultContent(props) {
    return (
        <>
            {
                (
                    props.error.isError ? ErrorContent(props.error.message) : SuccessContent(props.shortUrl)
                )
            }
        </>
    );
}

export default ResultContent;