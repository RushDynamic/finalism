import React, { useState } from "react";
import { validateUrl } from "../../services/validation-util";
import '../../styles/submit.scss';
import { shortenUrl } from "../../services/finalism-api-service";
import Loading from "./Loading";
import ResultContainer from './ResultContainer.js';

function Submit() {
    const [resultFetched, setResultFetched] = useState(false);
    const [isLoading, setIsLoading] = useState(false);
    const [error, setError] = useState({ isError: false, message: '' });
    const [inputUrl, setInputUrl] = useState("");
    const [outputUrl, setOutputUrl] = useState("");

    const handleOnSubmitUrl = async () => {
        setIsLoading(true);
        if (validateUrl(inputUrl)) {
            try {
                const respData = await shortenUrl(inputUrl);
                setOutputUrl(`${process.env.REACT_APP_CUR_URL}/${respData.shortenUrlOutput.shortenedUrl}`);
                setError({ isError: false });
            }
            catch (err) {
                setError({ isError: true, message: "Something went wrong :x" });
            }
        } else {
            setError({ isError: true, message: "That doesn't seem right :[" });
        }
        setIsLoading(false);
        setResultFetched(true);
    }

    const handleOnSubmitUrlChange = async (e) => {
        setInputUrl(e.target.value);
    }

    const handleOnKeyDown = (e) => {
        if (e.key === 'Enter') {
            handleOnSubmitUrl();
        }
    }

    return (
        <div className='submit-container'>
            <div className='submit-inner-container'>
                <input className='submit-input-field' onChange={handleOnSubmitUrlChange} onKeyDown={handleOnKeyDown} placeholder='Paste a URL here and hit enter' autoFocus />
            </div>
            {isLoading ? <Loading /> : <div className='result-container'>
                <ResultContainer resultFetched={resultFetched} outputUrl={outputUrl} error={error} />
            </div>}
        </div>)
}

export default Submit;