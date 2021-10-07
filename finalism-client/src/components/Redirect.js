import { useParams } from "react-router-dom";
import { useEffect } from "react";
import { fetchOriginalUrl } from "../services/finalism-api-service";
import '../styles/redirect.scss';

function Redirect() {
    const { url } = useParams();

    useEffect(() => {
        (async function () {
            const respData = await fetchOriginalUrl(url);
            console.log("respData:", respData);
            //respData.originalUrlOutput.originalUrl != null ? window.location.href = respData.originalUrlOutput.originalUrl : console.log("return to 404");
        })();
    }, []);

    return (
        <div className="redirect-container">
            <h1>You're about to be redirected...</h1>
        </div>
    )
}

export default Redirect;