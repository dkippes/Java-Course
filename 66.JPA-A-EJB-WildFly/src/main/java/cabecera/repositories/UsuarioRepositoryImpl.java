package cabecera.repositories;

import cabecera.configs.MysqlConn;
import cabecera.configs.Repository;
import cabecera.models.entities.Usuario;
import jakarta.inject.Inject;

import java.sql.*;
import java.util.List;

@Repository
@RepositoryJdbc
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Inject
    @MysqlConn
    private Connection conn;

    @Override
    public List<Usuario> listar() throws SQLException {
        return null;
    }

    @Override
    public Usuario porId(Long id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(Usuario usuario) throws SQLException {

    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }

    @Override
    public Usuario porUsername(String username) throws SQLException {
        Usuario usuario = null;
        try (
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuarios WHERE username=?")
        ) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setId(rs.getLong("id"));
                    usuario.setUsername(rs.getString("username"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setEmail(rs.getString("email"));
                }
            }
        }
        return usuario;
    }
}
