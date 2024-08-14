const url = 'http://localhost:8080/api/auth/register';

const registerUser = async (username, password) => {
    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            mode: 'cors',
            body: JSON.stringify({username, password})
        });

        if (!response.ok) {
            const err = await response.text();
            throw new Error(`Error: ${err}`);
        }

        return await response.json();

    } catch (e) {
        console.log('Internal server error:', e);
        throw e;
    };
};

module.exports = {
    registerUser,
}
