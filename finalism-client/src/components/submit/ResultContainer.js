import ResultContent from "./ResultContent";

const ResultContainer = (props) => {
    return (props.resultFetched && (
        <div className="result-container">
            <div className="result-inner-container">
                <ResultContent shortUrl={props.outputUrl} error={props.error} />
            </div>
        </div>)
    )
}

export default ResultContainer;