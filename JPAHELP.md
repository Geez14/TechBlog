
            em.getTransaction().commit();

            response.getWriter().write("Entity saved with ID: " + entity.getId());
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            response.getWriter().write("Error: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void destroy() {
        if (emf != null) {
            emf.close();
        }
    }
}
```

#### 5. **Deploy and Run**
- Deploy the servlet in your web application.
- Access the servlet via the configured URL (e.g., `http://localhost:8080/your-app/jpa-servlet`).

This setup enables you to use JPA seamlessly within your servlet. You can expand this by integrating a service layer or dependency injection (e.g., Spring) for better modularity and maintainability.