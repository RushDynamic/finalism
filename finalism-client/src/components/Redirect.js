import { useParams, useHistory } from "react-router-dom";
import { useEffect } from "react";
import { fetchOriginalUrl } from "../services/finalism-api-service";
import { formatUrl } from "../services/validation-util";
import '../styles/redirect.scss';

function Redirect() {
    const { url } = useParams();
    const history = useHistory();

    useEffect(() => {
        (async function () {
            const respData = await fetchOriginalUrl(url);
            console.log("respData:", respData);
            if (respData.originalUrlOutput.success !== true) {
                history.push('/404');
            }
            else {
                let cleanUrl = formatUrl(respData.originalUrlOutput.originalUrl);
                window.location.href = cleanUrl;
            }
        })();
    }, []);

    return (
        <div className="redirect-container">
            <h1>You're about to be redirected...</h1>
        </div>
    )
}

export default Redirect;