const ResultSegment = (resultFetched, shortUrl) => {
    return (resultFetched && (
        <div className="result-container">
            <div className="result-inner-container">
                <h4>Here's your shortened URL:</h4>
                <h2 style={{ marginTop: '0vh' }}>{shortUrl}</h2>
                <button className="result-copy-btn" type="button" onClick={() => navigator.clipboard.writeText(shortUrl)}>COPY</button>
            </div>
        </div>)
    )
}

export default ResultSegment;