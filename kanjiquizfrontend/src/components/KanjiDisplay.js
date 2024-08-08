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
    const [level, setLevel] = useState('');
    const [guess, setGuess] = useState('');
    const [message, setMessage] = useState('');

    const getKanji =() => {
        KanjiService.getKanji()
            .then((kanji) => {
                setKanji(kanji)
            });
    }

    useEffect(() => {
        getKanji();
    }, []);

    const handleGuess = (event) => {
        event.preventDefault();
        if (kanji.reading.includes(guess)) {
            setMessage('Correct')
            getKanji();
        } else {
            setMessage('Incorrect')
        }
        setGuess('')
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
                    onSubmit={handleGuess}
                >
                    {kanji && <Typography fontFamily={ipagothic} variant={"h1"} align={"center"}>{kanji.kanji}</Typography>}
                    {kanji && <Typography flexGrow={1} fontSize={24} variant={"body1"} align={"center"}>{kanji.meaning}</Typography>}
                    {kanji && <Typography flexGrow={1} fontSize={20} variant={"body1"} align={"center"}>{message}</Typography>}
                    <TextField
                        fullWidth
                        name={"guessfield"}
                        id={"guessfield"}
                        type={"text"}
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
                </Box>
            </Container>
        </ThemeProvider>
    );

};

export default KanjiDisplay;

