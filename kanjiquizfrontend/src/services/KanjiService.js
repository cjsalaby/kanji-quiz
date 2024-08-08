const url = 'http://localhost:8080/api/kanji/random'

const getKanji = async () => {
    try {
        const response = await fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
            mode: 'cors'
        });

        if (response.ok) {
            return await response.json();
        } else {
            return [];
        };

    } catch (e) {
        console.log('getKanji error: ', e);
        throw e;
    };
};

module.exports = {
    getKanji,
}