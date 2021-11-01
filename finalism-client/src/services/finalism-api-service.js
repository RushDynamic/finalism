export async function shortenUrl(originalUrl) {
    let apiUrl = `${process.env.REACT_APP_API_URL}/shorten`;
    let reqPayload = { originalUrl: originalUrl };
    let resp = await fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(reqPayload)
    });
    return await resp.json();
}

export async function fetchOriginalUrl(shortUrl) {
    let apiUrl = `${process.env.REACT_APP_API_URL}/fetch/${shortUrl}`;
    let resp = await fetch(apiUrl, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    });
    return await resp.json();
}