import React, { useState } from "react";
import validUrl from 'valid-url';
import '../../styles/submit.scss';
import { shortenUrl } from "../../services/finalism-api-service";
import ResultSegment from './ResultSegment.js';

function Submit() {
    const [resultFetched, setResultFetched] = useState(false);
    const [isError, setIsError] = useState(false);
    const [inputUrl, setInputUrl] = useState("");
    const [outputUrl, setOutputUrl] = useState("");

    const handleOnSubmitUrl = async () => {
        if (validUrl.isWebUri(inputUrl)) {
            const respData = await shortenUrl(inputUrl);
            setOutputUrl(`http://localhost:3000/${respData.shortenUrlOutput.shortenedUrl}`);
            setIsError(false);
        } else {
            setIsError(true);
        }
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
            <div className='result-container'>
                {ResultSegment(resultFetched, outputUrl, isError)}
            </div>
        </div>)
}

export default Submit;