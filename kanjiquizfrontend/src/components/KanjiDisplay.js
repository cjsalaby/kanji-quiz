import React, {useEffect, useState} from "react";
import KanjiService from '../services/KanjiService';
import {Box, Button, Container, createTheme, TextField, ThemeProvider, Typography} from "@mui/material";
import IPAGothic from '../resources/fonts/IPAGothic.ttf';

const theme = createTheme()

const ipagothic = {
    fontFamily: 'IPAGothic',
    fontStyle: 'normal',
    fontWeight: 700,
}

const KanjiDisplay = () => {

    const [kanji, setKanji] = useState(null);
    const [guess, setGuess] = useState('');
    const [message, setMessage] = useState('');

    useEffect(() => {

        KanjiService.getKanji()
            .then((kanji) => {
                setKanji(kanji)
            });

    }, []);

    const handleGuess = () => {
        if (guess === kanji.reading) {
            setMessage('Correct')
        } else {
            setMessage('Incorrect')
        }
    };

    return (
        <ThemeProvider theme={theme}>
            <Container component={"main"} maxWidth={"sm"} alignItems={"center"} direction={"column"}>
                <Box
                    component={"form"}
                    sx={{m:1, padding: 4}}
                    alignItems={"center"}
                    flexDirection={"column"}
                    flexGrow={1}
                    boxShadow={1}
                >
                    {kanji && <Typography fontFamily={ipagothic} variant={"h1"} align={"center"}>{kanji.kanji}</Typography>}
                    {kanji && <Typography flexGrow={1} variant={"body1"} align={"center"}>{kanji.meaning}</Typography>}
                    <TextField
                        fullWidth
                        margin="normal"
                        value={guess}
                        onChange={e => setGuess(e.target.value)}
                        label="Enter kana"
                    />
                    <Button
                        fullWidth
                        onClick={handleGuess}
                        variant="contained"
                        sx={{ mt: 1, mb: 1 }}
                    >
                        Submit
                    </Button>
                    <p>{message}</p>
                    {kanji && <p>Meaning: {kanji.meaning}</p>}

                </Box>
            </Container>
        </ThemeProvider>
    );

};

export default KanjiDisplay;

