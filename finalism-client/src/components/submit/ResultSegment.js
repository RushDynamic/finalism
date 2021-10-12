import ResultContent from "./ResultContent";

const ResultSegment = (resultFetched, shortUrl, isError) => {
    return (resultFetched && (
        <div className="result-container">
            <div className="result-inner-container">
                <ResultContent shortUrl={shortUrl} isError={isError} />
            </div>
        </div>)
    )
}

export default ResultSegment;