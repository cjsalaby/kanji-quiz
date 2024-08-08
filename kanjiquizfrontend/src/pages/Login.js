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

const defaultTheme = createTheme();

export default function SignIn() {
    const handleSubmit = (event) => {
        event.preventDefault();
        const data = new FormData(event.currentTarget);
        console.log({
            email: data.get('email'),
            password: data.get('password'),
        });
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
                  <Typography component={"h1"} variant={"h5"}>Sign in</Typography>
                  <Box component={"form"} onSubmit={handleSubmit} noValidate sx={{mt:1}}>
                      <TextField
                          margin="normal"
                          required
                          fullWidth
                          id="email"
                          label="Email Address"
                          name="email"
                          autoComplete="email"
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
                          autoComplete="current-password"
                      />
                      <Button
                          type="submit"
                          fullWidth
                          variant="contained"
                          sx={{ mt: 3, mb: 2 }}
                      >
                          Sign In
                      </Button>
                      <Grid container alignItems={"center"} direction={"column"}>
                          <Grid item xs>
                              <Link href={"/signup"} variant={"body2"}>
                                  {"Don't have an account? Sign up"}
                              </Link>
                          </Grid>
                      </Grid>
                  </Box>
              </Box>
          </Container>
      </ThemeProvider>
    );


}