export async function shortenUrl(originalUrl) {
    // http://localhost:8080/shorten
    let apiUrl = 'http://localhost:8080/shorten';
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