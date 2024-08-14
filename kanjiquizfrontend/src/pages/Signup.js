import {
    Box,
    Button,
    Container,
    createTheme,
    CssBaseline, Grid,
    Link,
    TextField,
    ThemeProvider,
    Typography
} from "@mui/material";
import {useState} from "react";

import AuthenticationService from '../services/AuthenticationService'

const defaultTheme = createTheme();

export default function SignUp() {

    const [message, setMessage] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();
        const data = new FormData(event.currentTarget);

        const username = data.get('username');
        const password = data.get('password');
        const retypePassword = data.get('retype-password');
        console.log(username)

        if (password !== retypePassword) {
            setMessage("Passwords do not match");
            return;
        }

        try {
            await AuthenticationService.registerUser(username, password);
            setMessage("Registration successful.");
        } catch (e) {
            setMessage(`Registration failed: ${e.message}`)
        }
    };

    return (
        <ThemeProvider theme={defaultTheme}>
            <Container component={"main"} maxWidth={"xs"}>
                <CssBaseline />
                <Box
                    sx={{
                        marginTop: 8,
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'center',
                    }}
                >
                    <Typography component={"h1"} variant={"h5"}>Sign up</Typography>
                    <Box component={"form"} onSubmit={handleSubmit} noValidate sx={{mt:1}}>
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            id="username"
                            label="Username"
                            name="username"
                            autoComplete="username"
                            autoFocus
                        />
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            name="password"
                            label="Password"
                            type="password"
                            id="password"
                        />
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            name="retype-password"
                            label="Retype-Password"
                            type="password"
                            id="retype-password"
                        />
                        <Button
                            type="submit"
                            fullWidth
                            variant="contained"
                            sx={{ mt: 3, mb: 2 }}
                        >
                            Sign Up
                        </Button>
                        {message && <Typography color={"error"}>{message}</Typography>}
                    </Box>
                </Box>
            </Container>
        </ThemeProvider>
    );
}