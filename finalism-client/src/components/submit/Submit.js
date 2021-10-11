import React, { useState } from "react";
import '../../styles/submit.scss';
import { shortenUrl } from "../../services/finalism-api-service";
import ResultSegment from './ResultSegment.js';

function Submit() {
    const [resultFetched, setResultFetched] = useState(false);
    const [inputUrl, setInputUrl] = useState("");
    const [outputUrl, setOutputUrl] = useState("");

    const handleOnSubmitUrl = async () => {
        const respData = await shortenUrl(inputUrl);
        setResultFetched(true);
        setOutputUrl(`http://localhost:3000/${respData.shortenUrlOutput.shortenedUrl}`);
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
                <input className='submit-input-field' onChange={handleOnSubmitUrlChange} onKeyDown={handleOnKeyDown} placeholder='Paste a URL here and hit enter' />
            </div>
            <div className='result-container'>
                {ResultSegment(resultFetched, outputUrl)}
            </div>
        </div>)
}

export default Submit;