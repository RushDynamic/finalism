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
            try {
                const respData = await fetchOriginalUrl(url);
                if (respData.originalUrlOutput === null || respData.originalUrlOutput.success !== true) {
                    history.push('/404');
                }
                else {
                    let cleanUrl = formatUrl(respData.originalUrlOutput.originalUrl);
                    window.location.href = cleanUrl;
                }
            }
            catch (err) {
                history.push('/404');
            }
        })();
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <div className="redirect-container">
            <h1>You're about to be redirected...</h1>
        </div>
    )
}

export default Redirect;