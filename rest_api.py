from fastapi import FastAPI
from main_config.main import app as existing_project_app
import main_config.database_config.models as models
import os
from dotenv import load_dotenv


main_app = FastAPI()

models.create_tables()


main_app.mount("/rest_api", existing_project_app)